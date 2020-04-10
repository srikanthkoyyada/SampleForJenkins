pipeline {
     agent {
        
        label {
            label "master"
             customWorkspace "/usr/share/jenkins/EurekaServerGIT"
              }
        }
     
    stages {
            stage('SonarQube analysis') {
         withSonarQubeEnv('My SonarQube Server') {
              sh 'cd /usr/share/jenkins/EurekaServerGIT/'
             sh 'mvn clean package sonar:sonar'
         } // SonarQube taskId is automatically attached to the pipeline context
       }
     
     stage("Quality Gate"){
         timeout(time: 1, unit: 'HOURS') { // Just in case something goes wrong, pipeline will be killed after a timeout
         def qg = waitForQualityGate() // Reuse taskId previously collected by withSonarQubeEnv
         if (qg.status != 'OK') {
             error "Pipeline aborted due to quality gate failure: ${qg.status}"
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
