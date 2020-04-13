
pipeline{

	agent {
		label {
            label "master"
             customWorkspace "/usr/share/jenkins/EurekaServerGIT"
              }
        }
        environment { 
		 EMAIL_RECIPIENTS = 'srikanth.k@rknowsys.com'
		 }
        stages{

              stage('Quality Gate Status Check'){
                  steps{
                      script{
			      withSonarQubeEnv('SonarQube') { 
			     //sh "mvn sonar:sonar -Dsonar.exclusions=src/main/java/com/eureka/test/*.java"
			      sh "mvn sonar:sonar"
                       	     	}
			       timeout(time: 1, unit: 'HOURS') {
			      def qg = waitForQualityGate()
				      if (qg.status != 'OK') {
				      
					   error "Pipeline aborted due to quality gate failure: ${qg.status}"
					   
				      }
                    		}
   		      }
                 	
               	 }  
              }	
              stage('Build & Deploy'){
                  steps{
                      script{
			                        		
		    	    sh "mvn clean install"
		    	    withEnv(['JENKINS_NODE_COOKIE=DontKillMe']) {
						     sh "java -Dserver.port=8000 -jar target/EurekaServer.jar &"
						}
		    	
                 	}
               	 
              }	
            }	
            
                	     	         
}
 post {
				 success {
				 sendEmail("Successful")
				 }
				 failure {
				 sendEmail("Failed")
				 }
				}   
}

//@NonCPS
//def getChangeString() {
//		 MAX_MSG_LEN = 100
//		 def changeString = ""
//		
//		 echo "Gathering SCM changes"
//		 def changeLogSets = currentBuild.changeSets
//		 for (int i = 0; i < changeLogSets.size(); i++) {
//		 def entries = changeLogSets[i].items
//		 for (int j = 0; j < entries.length; j++) {
//		 def entry = entries[j]
//		 truncated_msg = entry.msg.take(MAX_MSG_LEN)
//		 changeString += " - ${truncated_msg} [${entry.author}]\n"
//		 }
//		 }
//		
//		 if (!changeString) {
//		 changeString = " - No new changes"
//		 }
//		 return changeString
//}

def sendEmail(status) {
		 mail (
		 to: "$EMAIL_RECIPIENTS", 
		 subject: "Build $BUILD_NUMBER - " + status + " ($JOB_NAME)", 
		 body: "Hello, Build "+status)
}
