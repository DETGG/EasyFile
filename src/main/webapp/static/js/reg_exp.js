function isANumber(obj){
    const reg = /^[0-9]+$/;
    if(!reg.test(obj)){
        return false;
    }else {
        return true;
    }
}
function checkBlankForm(obj)
{
    if (obj.length === 0) {
        return false;
    }
    return true;
}
function testEmail(obj){
//对电子邮件的验证
    const reg = /^([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+@([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+\.[a-zA-Z]{2,3}$/;
    if(!reg.test(obj))
    {
        return false;
    }else {
        return true;
    }
}