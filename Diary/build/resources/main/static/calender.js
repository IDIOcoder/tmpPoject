
    function viewCalendar(){
    // 사용자로 부터 입력받은 년월 정보를 읽어와서 값 설정
    let year = document.getElementById('year').value;
    let mon = document.getElementById('month').value;

    let cal = new Date(year,mon-1,1);
    let date = cal.getDay();
    console.log(date);
    cal = new Date(year,mon,0);
    let day = cal.getDate();
    console.log(day);
    let space = date;
    let lastDay = day;

    let month = makeCalendar(space,lastDay);
    let ele = document.getElementById('pos');
    ele.innerHTML = month;
}
    function makeCalendar(_space,_lastDay){
    let calendar = "";
    let space = _space;//4;
    let lastDay = _lastDay;//29;
    let moreSpace = 7-((space+lastDay)%7);
    calendar += `<table><tr><td> 일 </td><td> 월 </td><td> 화 </td><td> 수 </td><td> 목 </td><td> 금 </td><td> 토 </td></tr>`;
    calendar += '<tr>';
    for(let k=0;k<space;k++){
    calendar += `<td></td>`;
}
    for(let i=0;i<lastDay;i++){
    calendar += `<td> <a th:onclick="|location.href='@{/Diary}'|">${i+1} </a:link></td>`;
    if((i+1+space)%7==0){
    calendar += '</tr><tr>';
}
}
    for(let i=0;i<moreSpace;i++){
    calendar += `<td></td>`;
}
    calendar += "</tr></table>";
    //console.log(calendar);

        return calendar;
    }