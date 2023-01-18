pipeline {
    agent any

        tools {
            maven "M3"
        }

    stages {
        stage('Checkout') {
            steps {
                git branch: 'main', url: 'https://github.com/MartynasIT/SEB-Automation.git'
            }
        }
        stage('Selection') {
            parameters {
                choice(name: 'CHOICE', choices: ['Web', 'API','Both'], description: 'Choose whether to build a WEB or an API or Both')
                choice(name: 'BROWSER', choices: ['Chrome', 'Firefox', 'Edge'], description: 'Choose which browser to run the tests on')
            }
        }
        stage('Test') {
                steps {
                    script {
                        if (params.CHOICE == 'Web') {
                            bat "mvn -Dsurefire.suiteXmlFiles=src/test/resources/TestSuites/LegoSuite.xml -Dbrowser=Chrome test"
                        } else if (params.CHOICE == 'Api') {
                              bat "mvn -Dsurefire.suiteXmlFiles=src/test/resources/TestSuites/LegoSuite.xml -Dbrowser=Chrome test"
                        } else {
                             bat "mvn -Dsurefire.suiteXmlFiles=src/test/resources/TestSuites/LegoSuite.xml -Dbrowser=Chrome test"
                        
                        }
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