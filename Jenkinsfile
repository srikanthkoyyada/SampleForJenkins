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
            sh 'cd /home/rknowsys/EurekaServerGIT/EurekaServer1/'
            sh 'mvn clean install'
               }
            }
   
    stage('Deploy') {
       
            steps {
                 sh 'cd /home/rknowsys/EurekaServerGIT/EurekaServer1/target/'
                 sh 'export BUILD_ID=dontKillMe'
                 sh 'nohup java -Dserver.port=9000 -jar EurekaServer1-0.0.1-SNAPSHOT.jar &'
         }
       }
   
    }
  
  
}
