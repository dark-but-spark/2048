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
    function place()
    {
        const available=[];
        for(let i=0; i<size;i++)
        {
            for(let j=0;j<size;j++)
            {
                if(board[i][j]===0)
                {
                    available.push({x:i,y:j});
                }
            }
        }
        if(available.length>0)
        {
            const randomCell=available[Math.floor(Math.random()*available.length)];
            board[randomCell.x][randomCell.y]=Math.random()<0.9? 2:4;
            const cell=document.querySelector('[data-row="${randomCell.x}"][data-col="${randomCell.y}"]');
            cell.classList.add("new-tile");

        }
    }

    function move(direction)
    {
        let f_change=false;
        if(direction==='ArrowUp'||direction==="ArrowDown")
        {
            for(let j=0;j<size;j++)
            {
                const column=[...Array(size)].map((_,i)=>board[i][j]);
                const newColumn=transform(column,direction==="ArrowUp");
                for(let i=0;i<size;i++)
                {
                    if(board[i][j]!=newColumn[i])
                    {
                        f_change=true;
                        board[i][j]=newColumn[i];
                    }
                }
            }
        }
        else if (direction==="ArrowLeft"||direction==+"ArrowRight")
        {
            for(let i=0;i<size;i++)
            {
                const row=board[i];
                const newRow=transform(row,direction==="ArrowLeft");
                if(row.join(',')!==newRow.join(','))
                {
                    f_change=true;
                    board[i]=newRow;
                }

            }
            if(f_change)
            {
                place();
                render();
                checkGameOver();
            }
        }
    }

    function transform(line,moveTowardStart)
    {
        let newLine=line.filter(cell=>cell!=0);
        if(!moveTowardStart)
        {
            newLine.reserve();
        }
        for(let i=0;i<newLine.length-1;i++)
        {
            if(newLine[i]===newLine[i+1])
            {
                newLine[i]*=2;
                update(newLine[i]);
                newLine.splice(i+1,1);
            }
        }
        while(newLine.length<size)
        {
            newLine.push(0);
        }
        if(!moveTowardStart)
        {
            newLine.reserve();
        }
        return newLine;
    }

    function checkGameOver(){
        for(let i=0;i<size;i++){
            for(let j=0;j<size;j++){
                if(board[i][j]===0){
                    return ;
                }
                if(j<size-1 && board[i][j]===board[i][j+1]){
                    return ;
                }
                if(i<size-1 &&board[i][j]===board[i+1][j]){
                    return ;
                }
            }
        }
    }
})
