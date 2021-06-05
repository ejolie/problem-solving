function getCount(objects) {
    let cnt = 0;
    for (let o of objects) {
        if (o.x == o.y) { // cnt += (o.x == o.y);
            cnt += 1;
        }
    }
    return cnt;
}

/*
function getCount(objects) {
    return objects.filter(function(o) {return o.x == o.y}).length;
}
*/
// ES6
// return objects.filter(o => o.x == o.y).length;