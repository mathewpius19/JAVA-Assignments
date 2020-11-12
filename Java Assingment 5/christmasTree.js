const numberOfRows = 8;

var tree="";
var p="*";
for(i=0;i<numberOfRows;i++){
    for(j=i;j<numberOfRows;j++){
        tree+=" ";
    }
    for(k=0;k<(2*i)-1;k++){
       tree+=p
       p=0
    }
    tree+="\n"
}
console.log(tree)