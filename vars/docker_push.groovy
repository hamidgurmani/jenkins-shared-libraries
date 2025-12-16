def call(String Project, String ImageTag, String dockerhubuser){
  withCredentials([usernamePassword(credentialsId: 'DockerHubCred', passwordVariable: 'dockerHubPass', usernameVariable: 'dockerHubUser')]) {
      sh "docker login -u ${dockerhubUser} -p ${dockerHubPass}"
  }
  sh "docker push ${dockerhubUser}/${Project}:${ImageTag}"
}
