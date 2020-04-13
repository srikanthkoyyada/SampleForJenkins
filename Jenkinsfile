
pipeline{

	agent {
		label {
            label "master"
             customWorkspace "/usr/share/jenkins/EurekaServerGIT"
              }
        }
        stages{

              stage('Quality Gate Status Check'){
                  steps{
                      script{
			      withSonarQubeEnv('SonarQube') { 
			      sh "mvn sonar:sonar -Dsonar.exclusions=src/main/java/com/eureka/test/*.java"
                       	     	}
			       timeout(time: 1, unit: 'HOURS') {
			      def qg = waitForQualityGate()
				      if (qg.status != 'OK') {
				      mail to:"srikanth.k@rknowsys.com", subject:"FAILURE: ${currentBuild.fullDisplayName}", body: "Sonar Analysis Failed."
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
		    	   
		    	    mail to:"srikanth.k@rknowsys.com", subject:"SUCCESS: ${currentBuild.fullDisplayName}", body: "Build Successfull"
		      }
                 	
               	 }  
              }	
            }	       	     	         
}
