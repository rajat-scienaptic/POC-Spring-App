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
                sh "ps | grep POC-Spring-App | awk '{print \$1}' | xargs kill -9 || true"
                sh "env SERVER.PORT=9002 nohup java -jar ./target/POC-Spring-App-1.0-SNAPSHOT.jar &"
            }
         }
      }
   }
}