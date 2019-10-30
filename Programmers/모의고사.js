function solution(answers) {
    var one = [1, 2, 3, 4, 5];
    var two = [2, 1, 2, 3, 2, 4, 2, 5];
    var three = [3, 3, 1, 1, 2, 2, 4, 4, 5, 5];
    
    var idx1 = 0;
    var idx2 = 0;
    var idx3 = 0;
    var scores = [
        {
            id: 1, 
            score: 0
        },
        {
            id: 2,
            score: 0
        },
        {
            id: 3,
            score: 0
        }
    ];
    for (let i in answers) {
        if (answers[i] === one[idx1]) {
            scores[0].score++;
        } else if (answers[i] === two[idx2]) {
            scores[1].score++;
        } else if (answers[i] === three[idx3]) {
            scores[2].score++;
        }
        idx1 = (idx1 + 1) % 5;
        idx2 = (idx2 + 1) % 8;
        idx3 = (idx3 + 1) % 10;
    }
    
    var result = scores.sort((a, b) => {
        return a.score < b.score ? -1 : a.score > b.score ? 1 : 0
    }).map(o => o.id);
    
    return result;
}
