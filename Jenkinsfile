pipeline{
   agent any
   stages {
      stage('Build') {

         steps {

            // Get some code from a GitHub repository
            git 'https://github.com/rajat-scienaptic/POC-Spring-App.git'
            // Run Maven on a Unix agent.

            sh "mvn -Dmaven.test.failure.ignore=true clean package"
            // To run Maven on a Windows agent, use
            // bat "mvn -Dmaven.test.failure.ignore=true clean package"
         }

         post {
            // If Maven was able to run the tests, even if some of the test
            // failed, record the test results and archive the jar file.
            success {
                sh "ps | grep POC_Spring_APP | awk '{print \$1}' | xargs kill -9 || true"
                dir('/var/lib/jenkins/workspace/HP CI-CD') {
                    sh "sudo cp -i -v /target/POC_Spring_APP.jar /home/centos/CI-CD/POC_Spring_APP.jar"
                    sh "cd /home/centos/CI-CD"
                    sh "nohup java -jar POC_Spring_APP.jar &"
                }
            }
         }
      }
   }
}