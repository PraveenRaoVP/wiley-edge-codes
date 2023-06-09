console.log("Starting")

const userLogin = (username, pw) => {
    return new Promise((resolve, reject) => {
        setTimeout(() => {
            console.log("User logged in")
            resolve({ uname: username })
        }, 5000)
    });
}

const getProjectsByUser = (uname) => {
    return new Promise((resolve, reject) => {
        setTimeout(() => {
            console.log("Projects ")
            resolve(["proj1", "proj2"])
        }, 5000)
    })
}

const projDetails = () => {
    return new Promise((resolve, reject) => {
        setTimeout(() => {
            resolve("Project details")
        }, 5000)
    })
}

userLogin("Praveen", "password")
    .then(user => getProjectsByUser(user))
    .then(projects => projDetails[0])
    .then(details => console.log(details))
    .catch(err => console.log(err))
    .finally(() => console.log("final message"))

const displayUserProjectDetails = async () => {
    try{
        let userName = await userLogin("Praveen", "password");
        let projects = await getProjectsByUser(userName);
        let details = await projDetails(projects[0])
        console.log(details)
    } catch(error){
        console.log(error.message);
    }
}
displayUserProjectDetails()

console.log("Ending")