pipeline {
     agent {
        
        label {
            label "master"
             customWorkspace "/usr/share/jenkins/EurekaServerGIT"
              }
        }
     
    stages {
   stage('Sonar Analysis') { 
            steps {
           
            echo '-----------------begin sonar analysis----------------'
            sh 'cd /usr/share/jenkins/EurekaServerGIT/'
            sh 'mvn sonar:sonar'
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
                 sh 'kill -9 $(lsof -t -i:8000)'
                 sh 'java -Dserver.port=8000 -jar EurekaServer.jar &'
         }
       }
   
    }
  
  
}
