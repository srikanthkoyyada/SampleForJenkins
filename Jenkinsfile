pipeline {
     agent {
        
        label {
            label "master"
             customWorkspace "/usr/share/jenkins/EurekaServerGIT"
              }
        }
     
    stages {
            stage ("SonarQube analysis") {
             steps {
                withSonarQubeEnv('SonarQube') {
                   sh 'cd /usr/share/jenkins/EurekaServerGIT/'
                      sh 'mvn sonar:sonar'
                }

             }
          }
          stage ("Quaity Gate") {
             steps {
                def qualitygate = waitForQualityGate()
                if (qualitygate.status != "OK") {
                   error "Pipeline aborted due to quality gate coverage failure: ${qualitygate.status}"
                }
             }
          }
    stage('BuildAndPackage') { 
            steps {
           
            echo '-----------------build maven clean install----------------'
            sh 'cd /usr/share/jenkins/EurekaServerGIT/'
            sh 'mvn clean install'
               }
            }
   
    stage('DeployJAR') {
       
            steps {
                 sh 'cd /usr/share/jenkins/EurekaServerGIT/target/'
                 sh 'java -Dserver.port=8000 -jar EurekaServer.jar &'
         }
       }
   
    }
  
  
}
