node {
    stage('Checkout') {
        git 'https://github.com/rajat-scienaptic/POC-Spring-App.git'
    }

    stage('Build') {
        sh 'mvn -B -V -U -e clean package'
    }

    stage('Test') {
     steps {
        sh 'mvn test'
     }
     post {
        always {
             junit 'target/surefire-reports/*.xml'
        }
     }
   }

  stage('Deliver') {
      steps {
          sh './jenkins/scripts/deliver.sh'
      }
  }
}
