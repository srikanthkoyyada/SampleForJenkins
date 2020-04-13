
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
				      mail to:"srikanth.k@rknowsys.com", subject:"FAILURE: ${currentBuild.fullDisplayName},Changes:${CHANGES, showPaths=true, format="%a: %r %p \n--\"%m\"", pathFormat="\n\t- %p"}", body: "Sonar Analysis Failed."
					   error "Pipeline aborted due to quality gate failure: ${qg.status}"
					   
				      }
                    		}
		    	    sh "mvn clean install"
		    	    mail to:"srikanth.k@rknowsys.com", subject:"SUCCESS: ${currentBuild.fullDisplayName},Changes:${CHANGES, showPaths=true, format="%a: %r %p \n--\"%m\"", pathFormat="\n\t- %p"}", body: "Build Successfull"
		      }
                 	
               	 }  
              }	
            }	       	     	         
}
