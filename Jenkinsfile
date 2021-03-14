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
                sh "mvn test -Dbrowser=${browser}"
            }
        }
        stage("Deploying"){
            steps{
                echo 'Deploying'
            }
        }
    }
}
