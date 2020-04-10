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
             sh 'mvn sonar:sonar'
         } // SonarQube taskId is automatically attached to the pipeline context
       }
            }
     
     
    stage('BuildAndPackage') { 
            steps {
           
            echo '-----------------build maven clean install----------------'
            sh 'cd /usr/share/jenkins/EurekaServerGIT/'
            sh 'mvn install'
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
