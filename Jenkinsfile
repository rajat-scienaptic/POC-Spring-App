pipeline{
   agent any
   stages {
      stage('Build') {
         steps {
            // Get code from a GitHub repository
            git 'https://github.com/rajat-scienaptic/POC-Spring-App.git'
            // Run Maven on a Unix agent.

            sh "mvn -Dmaven.test.failure.ignore=true clean package"
         }

         post {
            // If Maven was able to run the tests, even if some of the test
            // failed, record the test results and archive the jar file.
            success {
                sh "ps aux | grep - PocSpringAPP | awk '{print \$1}' | xargs kill -9 || true"
                dir('/var/lib/jenkins/workspace/HP-CI-CD/target'){
                 sh "java -jar PocSpringAPP.jar &"
                 echo "started java jar"
                }
            }
         }
      }
   }
}