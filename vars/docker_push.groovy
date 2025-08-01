def call(String Project, String Image, String dockerhubuser){
   withCredentials([usernamePassword
        ('credentialsId':"dockerHubCred",
        passwordVariable:"dockerHubPass",
        usernameVariable:"dockerHubUser")]){
        bat "docker login -u %dockerHubUser% -p %dockerHubPass%"
        bat "docker tag vaultify-backend %dockerHubUser%/vaultify-backend"
        bat "docker push %dockerHubUser%/vaultify-backend"
   }
}
