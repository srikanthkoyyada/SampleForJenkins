pipeline {
     agent {
        
        label {
            label "master"
             customWorkspace "/usr/share/jenkins/EurekaServerGIT"
              }
        }
     
    stages {
            stage('SonarQube analysis') {
                 steps {
         withSonarQubeEnv('SonarQube') {
              sh 'cd /usr/share/jenkins/EurekaServerGIT/'
             sh 'mvn clean install sonar:sonar'
         }
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
