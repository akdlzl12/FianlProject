<%@ page pageEncoding="UTF-8"%>
<style>
	.nav-tabs {
	     width: 1770px;
	     height: 51px;
	     margin-left: 15px;
	     padding: 5px;
	     background-color: #6a5dc0;
	 }
	ul.nav-tabs > li > a {
	     font-size: 17px;
	     color: white;
	 }
	ul.nav-tabs > li.active > a {
	     font-weight: bolder;
	     font-size: 20px;
	     color: #6a5dc0 ;
	 }
</style>

       <div class="row">
            <ul class="nav nav-default nav-tabs">
              <li role="presentation" class="${nowPage eq 'mainPage' ? 'active' : '' }"><a href="home.esc">발권</a></li>
              <li role="presentation" class="${nowPage eq 'refundPage' ? 'active' : '' }"><a href="refund.esc">환불</a></li>
            </ul>
        </div>