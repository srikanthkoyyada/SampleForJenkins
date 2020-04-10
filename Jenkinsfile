pipeline {
     agent {
        
        label {
            label "master"
             customWorkspace "/home/srikanthk/EurekaServerGIT"
              }
        }
     
    stages {
    stage("SonarQube analysis") {
          steps {
                echo '-----------------sonar analysis----------------'
                sh 'cd /home/srikanthk/EurekaServerGIT/'
              withSonarQubeEnv('My SonarQube Server') {
                 sh 'mvn sonar:sonar'
              }
          }
      }

      stage("Quality Gate"){
          timeout(time: 1, unit: 'HOURS') {
              def qg = waitForQualityGate()
              if (qg.status != 'OK') {
                  error "Pipeline aborted due to quality gate failure: ${qg.status}"
              }
          }
      }
    stage('BuildAndPackage') { 
            steps {
           
            echo '-----------------build maven clean install----------------'
            sh 'cd /home/srikanthk/EurekaServerGIT/'
            sh 'mvn clean install'
               }
            }
   
    stage('DeployJAR') {
       
            steps {
                 sh 'cd /home/srikanthk/EurekaServerGIT/target/'
                 sh 'export BUILD_ID=dontKillMe'
                 sh 'nohup java -Dserver.port=8000 -jar EurekaServer.jar &'
         }
       }
   
    }
  
  
}
