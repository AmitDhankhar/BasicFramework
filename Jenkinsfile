pipeline{
    agent master
    
    stages{
        stage ('Initialize') {
            steps {
                sh '''
                    echo "PATH = ${PATH}"
                    echo "M2_HOME = ${M2_HOME}"
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
                sh "mvn test"
            }
        }
        stage("Compile"){
            steps{
                echo 'Testing'
                sh "mvn compile"
            }
        }
        stage("Deploying"){
            steps{
                echo 'Deploying'
            }
        }
    }
}
