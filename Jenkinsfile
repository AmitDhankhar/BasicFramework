pipeline{
    agent any
    
    stages{
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
