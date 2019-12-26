pipeline {
     agent {
        
        label {
            label "master"
             customWorkspace "/home/rknowsys/EurekaServerGIT"
              }
        }
     
    stages {
    stage('BuildAndPackage') { 
            steps {
           
            echo '-----------------build maven clean install----------------'
            sh 'cd /home/rknowsys/EurekaServerGIT/'
            sh 'mvn clean install'
               }
            }
   
    stage('DeployJAR') {
       
            steps {
                 sh 'cd /home/rknowsys/EurekaServerGIT/target/'
                 sh 'export BUILD_ID=dontKillMe'
                 sh 'nohup java -Dserver.port=9000 -jar EurekaServer.jar &'
         }
       }
   
    }
  
  
}
