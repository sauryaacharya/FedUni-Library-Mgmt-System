$(document).ready(function(){
    getUserComments();
    
    $("#comment_post_btn").click(function(){
        var comment_text = $("#comment_text").val();
        var trimmed_text = $.trim(comment_text);
        if(trimmed_text != ""){
            postUserComments();
        }
    });
    
    $("#bookmark_btn").click(function(){
        postBookMark();
    });
    
    $("#loan_book_btn").click(function(){
        loanBook();
    });
});

function getUserComments()
{
    var book_id = $("#book_id").val();
    $.ajax({
       url: "Comment?book_id="+book_id,
       type: "GET", 
       cache: false,
       beforeSend: function(){
           
       },
       success: function(data){
           //alert(data.comments[0].comment);
           $("#num_cmnt").html(data.comments.length);
           if(data.comments.length != 0){
               $("#users_comment").html(getCommentHtml(data));
               
           }else{
               $("#users_comment").html("<span style='font-family:Arial;font-size:12px;color:#555;'>No comment yet.</span>");
           }
           
       }
    });
}

function postUserComments()
{
    var comment = $("#comment_text").val();
    var book_id = $("#book_id").val();
    
    $.ajax({
       url: "Comment", 
       type: "POST", 
       data: {comment_text : comment, book_id : book_id},
       beforeSend: function(){
           
       },
       success: function(data){
           
       },
       complete: function(){
           getUserComments();
       }
    });
}

function postBookMark()
{
    
    var book_id = $("#book_id").val();
    
    $.ajax({
       url: "BookMarks", 
       type: "POST", 
       data: {book_id : book_id},
       beforeSend: function(){
           
       },
       success: function(data){
           if(data.status == "failed"){
               alert("Already exists in bookmark.");
           }
           else if(data.status == "added"){
               alert("Added to bookmark.");
           }
           
       },
       complete: function(){
           
       }
    });
}

function loanBook()
{
    var book_id = $("#book_id").val();
    
    $.ajax({
       url: "Loan", 
       type: "POST", 
       data: {book_id : book_id},
       beforeSend: function(){
           
       },
       success: function(data){
           if(data.status == "failed"){
               alert("Already on loan.");
           }
           else if(data.status == "success"){
               alert("This book has been added to your loan.");
               location.href = "Books?id="+book_id;
           }
           
       },
       complete: function(){
           
       }
    });
}


function getCommentHtml(json_data)
{
    var i;
    var data_length = json_data.comments.length;
    var html = "";
    
    for(i = 0; i < data_length; i++)
    {
        html += "<div class='each_comment'>";
        html += "<span style='font-family:Arial;font-weight:bold;font-size:12px;color:#555;'>"+json_data.comments[i].user+"</span><br/>";
        html += "<span style='font-family:Arial;font-size:10px;color:#888;'>"+json_data.comments[i].time+"</span><br/>";
        html += "<span style='font-family:Arial;font-size:12px;color:#555;'>"+json_data.comments[i].comment+"</span>";
        html += "</div>";
    }
    return html;
}

