<%-- 
    Document   : login
    Created on : Aug 15, 2020, 9:24:27 AM
    Author     : duckh
--%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div id="Login" class="container">
    <!-- Button trigger modal -->
    <button type="button" class="btn btn-primary btn-lg" data-toggle="modal" data-target="#modelId">
        Đăng nhập

    </button>
    <!-- Modal -->
    <div class="modal fade" id="modelId" tabindex="-1" role="dialog" aria-labelledby="modelTitleId"
         aria-hidden="true" >
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title">Cinema Login</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">    

                    <form action="Login" method="POST">
                        <div class="body-login">
                            <div class="user">
                                 <i class="fas fa-user"></i>
                            <s:textfield  id="username" name="username" placeholder="Username"/>
                            </div>
                            <div class="user">
                                <i class="fas fa-lock"></i>
                            <s:password id="password" name="password" placeholder="Password"/>
                            </div>
                            
                        </div>
                        <div class="forgot-and-remember">                         
                            <div class="footer-left">
                                <input type="checkbox">
                                <span>Nhớ mật khẩu</span>
                            </div>
                            <div class="footer-right">
                                <a href="#">Quên mật khẩu?</a>
                            </div>
                        </div>
                        <div class="footer-login">
                            <s:submit  class="btn btn-primary" value="Đăng nhập"/>
                        </div>
                    </form>
                </div>
                <div class="modal-footer">
                    <p>Hoặc</p>
                    <div class="Link-with-app">

                        <span class="link-fb">
                            <i class="fab fa-facebook"><span>Facebook</span></i>

                        </span>
                        <span class="link-gg">
                            <i class="fab fa-google"><span>Google</span></i>

                        </span>
                        <span class="link-mi">
                            <i class="fab fa-windows"><span>Microsoft</span></i>
                        </span>                       
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
