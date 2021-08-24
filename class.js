ImageViewer = Class({
	name: "ImageViewer",
	
	construct: function (divId,title,photoList) {
		var div = document.createElement("div");
		var that=this;
		var divId = divId
        div.id = divId;
        this.divId = divId;
        


        var domChk = document.querySelector("#" + divId);
        if (domChk) {
            domChk.innerHTML = "";
        } else {
            document.getElementById("mainUI").appendChild(div);
        }
        
        this._window = new UI.window(divId,
            {
                width: "1225px",
                height: "540px",
                title: title,
            }
        );
		var photoList = photoList
		that.photoList=photoList
		
		var photo = document.createElement("img");
		photo.id= divId+"_src"
		photo.flag=0
		photo.src=photoList[0];
			
        var content = this._window.domContent;
        this.content = content;
		
        var div = document.createElement("div");
        div.id = "imgContainer";
		div.style.textAlign="center"
		div.appendChild(photo)
        content.appendChild(div);
		document.getElementById("imgContainer").style.height="465px"
		
        
		var Btndiv = document.createElement("div");
        Btndiv.id = "BtnContainer";
		Btndiv.style.textAlign = "center";
        content.appendChild(Btndiv);

		var date = new Date();
        var domIdPrefix = "__ui" + date.getHours() + date.getMinutes() + date.getSeconds() + date.getMilliseconds();
        
		var domNextBtn = domIdPrefix + "_nextBtn";		// 처음이미지 보기
        var domPreBtn = domIdPrefix + "_preBtn";			// 이전이미지 보기

		var nextBtnDiv =document.createElement('div')
		var preBtnDiv =document.createElement('div')
		
		nextBtnDiv.id=domNextBtn;
		preBtnDiv.id=domPreBtn;
		Btndiv.appendChild(preBtnDiv);
		Btndiv.appendChild(nextBtnDiv);
		
		
		this.preBtn= new UI.button(domPreBtn,
		{
			icon: 'url("./images/business/icon_pre.png")',
			tooltip:"이전 사진",
			onClick: function() {
					img = document.getElementById(divId+"_src")
					if(img.flag==0){
						alert("처음이미지입니다")
					}else{
						img.flag=img.flag-1
						img.src=that.photoList[img.flag]
					}
					
                },
		})
		this.nextBtn= new UI.button(domNextBtn,
		{
			icon: 'url("./images/business/icon_next.png")',
			tooltip:"다음 사진",
			onClick: function() {
					img = document.getElementById(divId+"_src")
					if(img.flag==photoList.length-1){
						alert("마지막 이미지입니다")
					}else{
						img.flag=img.flag+1
						img.src=that.photoList[img.flag]
					}
					
                },
		})
				
	},
	
	methods : {
		show: function (searchCondition) {
            this._window.show();
        },
	},
})