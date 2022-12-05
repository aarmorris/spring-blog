$(document).ready(function (){
    $(".editButton").on('click', function (e){
        console.log(e.target.dataset.id);
        window.location.replace(`/posts/${$(this).attr("data-id")}/edit`)
    });
});