const balancedBrackets = (stringToCheck)=>{
    const openingBrackets = "({["
    const closingBrackets = ")}]"
    const bracketObj = {"}":"{","]":"[",")":"("}
    const stack=[]
    if(stringToCheck.length===0){
        return false
    }
    for(char of stringToCheck){
        if(openingBrackets.indexOf(char)!==-1){
            stack.push(char)
        }
        
    
        else if(closingBrackets.indexOf(char)!==-1){
            if(stack.length===0){
                return false
            }
            else if((stack[stack.length-1]===bracketObj[char])){
            stack.pop();
            
            }
            else{
                return false
            }
        }
        
        else{
            return false
        }
    }
    // console.log(stack)
    if(stack.length===0){
    return true
    }
    else{
        return false
    }
}

console.log(balancedBrackets("{[()]}"));//true
console.log(balancedBrackets("{[{]}"));//false
console.log(balancedBrackets("{()}"));//true
console.log(balancedBrackets("{][]}"));//false



