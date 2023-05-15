/*requires init stage validators - credentials from validators.groovy*/
stages {
        stage('Init') {
            steps {
                script {
                    validators = load pwd() + "/pipelines/shared/validators.groovy"
                    validators.init(params.job)
                    validators.environmentName(params.env_name)

/*for every important value for variable is taken from seperate file*/
stage('Create Server') {
            steps {
                script {
                    currentBuild.displayName = "#${BUILD_NUMBER} ${params.env_type} ${params.env_name} ${params.server_name}"

                    aws = load pwd() + "/pipelines/shared/aws.groovy"
                    def aws_vars = aws.getVars()
                    if (params.ami_id == "") {
                        def aws_ami_info = load pwd() + "/pipelines/shared/aws_ami_info.groovy"
                        echo "No ami_id specified. Getting the stable version of '${server_type}' ami"
                        def assume_role_response = aws.assumeRole('sec_ami')
                        withEnv(assume_role_response.creds_env_list) {
                            try {
                                base_ami = aws_ami_info.getImageByVersion(server_type, 'stable')
                            } catch (Exception e) {
def subnet_options = [
    'private-use1-az1',
    'private-use1-az2',


