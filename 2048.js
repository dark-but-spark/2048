document.addEventListener('DOMContentLoaded',()=>{
    const grid=document.querySelector('.grid');
    const size=4;
    let board=[];
    let cnt=0;
    const cntElem= document.getElementById("current-score");

    let mx= localStorage.getItem("2048-highScore")|| 0;
    const mxElem=document.getElementById("high-score");
    mxElem.textContent=mx;

    const GGElem= document.getElementById("game-over");

    function update(value)
    {
        cnt+=value;
        cntElem.textContent=cnt;
        if(cnt>mx)
        {
            mx=cnt;
            mxElem.textContent= mx;
            localStorage.setItem('2048-highScore',mx);
        }
    }


    function restart()
    {
        cnt=0;
        cntElem="0";
        GGElem.style.diaplay='none';
        init();
    }

    function init()
    {
        board=[...Array(size)].map(e => Array(size).fill(0));
        place();
        place();
        render();
    }

    function render()
    {
        for(let i=0;i<size;i++)
        {
            for(let j=0;j<size;j++)
            {
                const cell=document.querySelector('[data-row="${i}"][data-col="${j}"]');
                const preValue= cell.dataset.value;
                const cntValue= board[i][j];
                if(cntValue!=0)
                {
                    cell.dataset.value=cntValue;
                    cell.textContent=cntValue;
                    if(cntValue!=parseInt(preValue)&& ! cell.classList.contains("new-tile"))
                    {
                        cell.classList.add("merged-tile");
                    }
                    else
                    {
                        cell.textContent='';
                        delete cell.dataset.value;
                        cell.classList.remove("merged-tile",'new-tile');
                    }
                }
            }
            setTimeout(() => {
               const cells=document.querySelectorAll("grid-cell");
               cells.forEach(cell=>{
                cell.classList.remove("merged-tile",'new-tile');
               });
            },300);
        }
    }

    

})
