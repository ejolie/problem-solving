function solution(participant, completion) {
    participant.sort();
    completion.sort();
    
    let answer = '';
    for (let i in participant) {
        if (participant[i] !== completion[i]) {
            answer = participant[i];
            break;
        }
    }
    return answer;
}
