
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
			      sh "mvn sonar:sonar"
                       	     	}
			       timeout(time: 1, unit: 'HOURS') {
			      def qg = waitForQualityGate()
				      if (qg.status != 'OK') {
					   error "Pipeline aborted due to quality gate failure: ${qg.status}"
					   mail to:"srikanth.k@rknowsys.com", subject:"FAILURE: ${currentBuild.fullDisplayName}", body: "Sonar Analysis Failed."
				      }
                    		}
		    	    sh "mvn clean install"
		      }
                 	
               	 }  
              }	
            }	       	     	         
}
