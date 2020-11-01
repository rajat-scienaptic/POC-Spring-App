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
      }

       stage('deploy') {
         echo 'branch name ' + env.BRANCH_NAME
         if (env.BRANCH_NAME.startsWith("dev")) {
          echo "Deploying to Dev environment after build"
         } else if (env.BRANCH_NAME.startsWith("master")) {
          echo "Deploying to PROD environment"
           sh "sudo kill -9 $(sudo lsof -t -i:9002)"
           dir('/var/lib/jenkins/workspace/HP-CI-CD/target'){
            sh "java -jar PocSpringAPP.jar"
           }
         }
       }
   }
}