pipeline{
    agent any
    
    stages{
        stage("Build"){
            steps{
                echo 'Building'
                bat "mvn clean"
            }
        }
        stage("Test"){
            steps{
                echo 'Testing'
                bat "mvn test"
            }
        }
        stage("Compile"){
            steps{
                echo 'Testing'
                bat "mvn compile"
            }
        }
        stage("Deploying"){
            steps{
                echo 'Deploying'
            }
        }
    }
}