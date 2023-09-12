## Construction of CI CD Pipeline via Jenkins 

This repo is for the practice of constructino of CI/CD Pipeline

1) WAS (Web Application Server)
 - Spring Boot 
 - Let's go Test (Deploy)

```bat
pipeline{
	agent any

	stages{
		stage('github Clone'){
			steps{
			    git branch: 'main',
				credentialsId:'tayGit', 
				url: 'https://github.com/taehyuklee/JenkinsServer.git'
			}
		}
		stage('build'){
			steps{
				sh '''
				start_build=`date`
                echo $start_build
                
				 echo 'start bootJar'
				 chmod +x ./gradlew
				 dos2unix ./gradlew
				 ./gradlew clean bootJar
				 
				 end_build=`date`
                 echo $end_build
				'''
			}
		}	
		stage('unit test'){
			steps{
				sh './gradlew test'
				//junit '**/build/test-results/test/TEST-*.xml' //이 부분이
				//junit '**/target/surefire-reports/TEST-*.xml' //원래 이렇게 되어 있었음
			}
		}
		stage('deploy'){
			steps{
			    
			    echo 'Spring Boot WAS 배포를 시작합니다.'

				sshPublisher(
					publishers: 
						[
							sshPublisherDesc(
								configName: 'ssh', 
								transfers: [sshTransfer(
									cleanRemote: false, 
									excludes: '', 
									//execCommand: '/home/taylee/WAS/sh/deploy.sh', 
									execTimeout: 120000, flatten: false, 
									makeEmptyDirs: false, 
									noDefaultExcludes: false, 
									patternSeparator: '[, ]+', 
									remoteDirectory: '/', 
									remoteDirectorySDF: false, 
									removePrefix: 'build/libs', 
									sourceFiles: 'build/libs/*.jar'
								)], 
								usePromotionTimestamp: false, 
								useWorkspaceInPromotion: false, 
								verbose: false)])
								

			    echo '배포가 끝났습니다.'

			}
		}
	}

	post {
        always {
            // JUnit 테스트 결과를 Jenkins에게 제공
            junit '**/build/test-results/test/*.xml'
        }
    }
}
```
