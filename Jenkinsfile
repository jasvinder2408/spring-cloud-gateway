pipeline {
  agent any



  stages {
    stage('Initialize') {
      steps {
        echo "PATH = ${PATH}"
        echo "M2_HOME = ${M2_HOME}"

      }
    }
      stage('Build'){
        steps{
          sh 'mvn -B -DskipTests clean package'
        }
      }
      stage('Test'){
        steps{
          sh 'mvn test'
        }
      }



      stage('Sonar qube analysis'){
        steps{
            withSonarQubeEnv('sonar-6'){
          sh 'mvn org.sonarsource.scanner.maven:sonar-maven-plugin:3.2:sonar'
        }
        }

      }


      // post {
      //   // If Maven was able to run the tests, even if some of the test
      //   // failed, record the test results and archive the jar file.
      //   success {
      //     junit '**/target/surefire-reports/TEST-*.xml'
      //     archiveArtifacts 'target/*.jar'
      //   }
      // }


  }
}
