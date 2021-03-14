pipeline{
    agent any
    environment{
        PATH = "/usr/local/Cellar/maven/3.6.1/bin:$PATH"
    }
    stages{
        stage ('Initialize') {
            steps {
                sh '''
                    echo "PATH = ${PATH}"
                    echo ${M2_HOME}
                    echo "JAVA_HOME = ${JAVA_HOME}"
                '''
            }
        }
        stage("Build"){
            steps{
                echo 'Building'
                sh "mvn clean"
            }
        }
        stage("Test"){
            steps{
                echo 'Testing'
                //publishHTML([allowMissing: false, alwaysLinkToLastBuild: false, keepAll: false, reportDir: 'Reports/${BUILD_TIMESTAMP}', reportFiles: '**/*.html', reportName: 'HTML Report', reportTitles: ''])
                sh "mvn test -Dbrowser=${browser} -DtimeStamp=${BUILD_TIMESTAMP}"
                //sh 'bundle install'
                //sh 'bundle exec rake build spec'
                //archive includes: 'pkg/*.gem'
                publishHTML([allowMissing: false, alwaysLinkToLastBuild: false, keepAll: false, reportDir: 'Reports/${BUILD_TIMESTAMP}', reportFiles: '**/*.html', reportName: 'HTML Report', reportTitles: ''])
            }
        }
        stage("Deploying"){
            steps{
                echo 'Deploying'
            }
        }
    }
}
