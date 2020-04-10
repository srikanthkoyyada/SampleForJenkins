pipeline {
     agent {
        
        label {
            label "master"
             customWorkspace "/home/srikanthk/EurekaServerGIT"
              }
        }
     
    stages {
   
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
