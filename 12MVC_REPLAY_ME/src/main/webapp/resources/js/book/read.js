/**
 * 
 */


const replyAddBtn = document.querySelector(".reply-add-btn");



replyAddBtn.addEventListener('click',()=>{
	
	const contents = document.querySelector('.reply-header textarea').value;
	
	axios
		.get(`${path}/book/reply/create?bookCode=${bookCode}&contents=${contents}`)
		.then((resp)=>{ 
			document.querySelector('.reply-header textarea').value = '';
			const item = resp.data.list;
			const cnt = resp.data.count;
			const replycntel = document.querySelector('.reply-cnt');
			replycntel.innerHTML = cnt;
            createReplyItem(item);
			document.querySelector('.reply-header textarea').focus();
		 })
		.catch((error)=>{ console.log(resp); })
})

window.addEventListener('load',()=>{
        axios
            .get(`${path}/book/reply/list?bookCode=${bookCode}`)
            .then((resp)=>{ 
                const items = resp.data.list;
                const cnt = resp.data.count;
                const replycntel = document.querySelector('.reply-cnt');
                replycntel.innerHTML = cnt;
                items.forEach(item=>{
					reciveReplyItem(item);
                })
            })
            .catch((error)=>{ console.log(resp); })
});


function createReplyItem(item){
	const itemEl = document.createElement('div');
	itemEl.className='item';
	const leftEl = document.createElement('div');
	leftEl.className='left';
	const profileEl = document.createElement('div');
	profileEl.className='profile';
	const usernameEl = document.createElement('div');
	usernameEl.className='username';
	usernameEl.innerHTML=item.username;
	const rightEl = document.createElement('div');
	rightEl.className='right';
	
	const dateEl = document.createElement('div');
	dateEl.className='date';
	dateEl.innerHTML=item.createAt;
	const contentEl = document.createElement('div');
	contentEl.className='content';
	
	const textAreaEl = document.createElement('textarea');
    textAreaEl.value = item.contents;
    textAreaEl.setAttribute('readonly', true);
	
	const buttonGroupEl = document.createElement('div');
	buttonGroupEl.className='button-group';
	//연결
	leftEl.appendChild(profileEl);
	leftEl.appendChild(usernameEl);
	
	contentEl.appendChild(textAreaEl);
	rightEl.appendChild(dateEl)
	rightEl.appendChild(contentEl)
	rightEl.appendChild(buttonGroupEl)
		
	itemEl.appendChild(leftEl);
	itemEl.appendChild(rightEl);
	
	const itemsEl = document.querySelector('.items');
	itemsEl.insertBefore(itemEl, itemsEl.firstChild);
}

function reciveReplyItem(item){
	const itemEl = document.createElement('div');
	itemEl.className='item';
	const leftEl = document.createElement('div');
	leftEl.className='left';
	const profileEl = document.createElement('div');
	profileEl.className='profile';
	const usernameEl = document.createElement('div');
	usernameEl.className='username';
	usernameEl.innerHTML=item.username;
	const rightEl = document.createElement('div');
	rightEl.className='right';
	
	const dateEl = document.createElement('div');
	dateEl.className='date';
	dateEl.innerHTML=item.createAt;
	const contentEl = document.createElement('div');
	contentEl.className='content';
	
	const textAreaEl = document.createElement('textarea');
    textAreaEl.value = item.contents;
    textAreaEl.setAttribute('readonly', true);
	
	const buttonGroupEl = document.createElement('div');
	buttonGroupEl.className='button-group';
	//연결
	leftEl.appendChild(profileEl);
	leftEl.appendChild(usernameEl);
	
	contentEl.appendChild(textAreaEl);
	rightEl.appendChild(dateEl)
	rightEl.appendChild(contentEl)
	rightEl.appendChild(buttonGroupEl)
		
	itemEl.appendChild(leftEl);
	itemEl.appendChild(rightEl);
	
	const itemsEl = document.querySelector('.items');
	itemsEl.appendChild(itemEl);
}



