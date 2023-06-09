var url = 'https://jsonplaceholder.typicode.com/posts'

fetch(url)
    .then(res => res.json())
    .then(data => {
        displayUserInfo(data)
    })
    .catch(err => console.log(err))

const displayUserInfo = (users) =>{
    let userElement = document.getElementById("data")
    let output = ""
    for(user of users){
        output+=`
        <div class="user">
        <div><b>UserId</b>:  ${user.userId}</div>
        <div><b>ID</b>: ${user.id}</div>
        <div><b>Title</b>: ${user.title}</div>
        <div><b>Content</b>: ${user.body}</div>
        </div>`
    }
    userElement.innerHTML = output
}
