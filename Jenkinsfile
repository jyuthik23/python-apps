/* Requires the Docker Pipeline plugin &
add environment variable key with value of path for docker files inside file "homebrew.mxcl.jenkins.plist"
<key>EnvironmentVariables</key>
	<dict>
	<key>PATH</key>
	<string>/usr/local/bin:/usr/bin:/bin:/usr/sbin:/sbin:/Applications/Docker.app/Contents/Resources/bin/:/Users/juythikkalathiya/Library/Group\ Containers/group.com.docker/Applications/Docker.app/Contents/Resources/bin</string>
	</dict> */
pipeline {
  agent {
    docker { image 'node:16-alpine' }
  }
  stages {
    stage('Test') {
      steps {
        sh 'node --version'
      }
    }
  }
}