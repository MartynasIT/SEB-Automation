pipeline {
  agent any

  tools {
    maven "M3"
  }

  parameters {
    choice(name: 'CHOICE', choices: ['WEB', 'API', 'Both'], description: 'Choose whether to build a WEB or an API or Both')
    choice(name: 'BROWSER', choices: ['Chrome', 'Edge'], description: 'Choose which browser to run the WEB tests on')
  }

  stages {
    stage('Web Test') {
      when {
        expression { params.CHOICE == 'WEB' || params.CHOICE == 'Both' }
      }
      steps {
        script {
          bat "mvn -Dsurefire.suiteXmlFiles=src/test/resources/TestSuites/AmazonSuite.xml -Dbrowser=${params.BROWSER} test"
        }
      }
    }

    stage('API Test') {
      when {
        expression { params.CHOICE == 'API' || params.CHOICE == 'Both' }
      }
      steps {
        script {
          bat "newman run Amazon.postman_collection.json -r html --reporter-html-export \"Reports/API_Report.html\""
        }
      }
    }
  }

  post {
    always {
      archiveArtifacts artifacts: 'Reports/*.json, Reports/*.html', fingerprint: true
      cleanWs()
    }
  }
}
