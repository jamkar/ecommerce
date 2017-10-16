pipeline {
    agent any
    stages {
        stage('build') {
            steps {
                sh 'mvn clean package'
            }
        }
	stage('test') {
		steps {
			echo 'Testing...'
		}
	}
	stage('Deploy staging') {
		steps {
			echo 'Deploy staging...'
		}
	}
	stage('Deploy production') {
		steps {
			echo 'Deploy production...'
		}	
	}
    
    }
}
