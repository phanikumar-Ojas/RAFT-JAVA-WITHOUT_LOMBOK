<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>RAFT Login</title>
   <link  href=""> 
     <link href="./WEB-INF/pages/Styles/bootstrap-4.3.1-bootstrap.min.css" rel="stylesheet" type="text/css" />
    <link href="./WEB-INF/pages/Styles/bootstrap-4.3.1-bootstrap.min.css" rel="stylesheet" type="text/css" />
    <script src="./Scripts/jquery-3.4.1.min.js" type="text/javascript" ></script>
    <script src="./Scripts/bootstrap-4.3.1-bootstrap.min.js" type="text/javascript"></script>

    <style>
        :root {
            --input-padding-x: 1.5rem;
            --input-padding-y: .75rem;
        }

        body {
            background: #fff; /*linear-gradient(to right, #0080A0, #68bed4);*/
        }

        .card-signin {
            border: 1px solid #0080A0;
            border-radius: 0.5rem;
            box-shadow: 0 0.5rem 0.5rem 0.8rem rgba(0, 0, 0, 0.1);
            overflow: hidden;
        }

            .card-signin .card-title {
                margin-bottom: 2rem;
                font-weight: 300;
                font-size: 1.5rem;
            }

            .card-signin .card-img-left {
                width: 45%;
                /* Link to your background image using in the property below! */
                /*background: scroll center url('https://source.unsplash.com/WEQbe2jBg40/414x512');*/
                background-size: cover;
            }

            .card-signin .card-body {
                padding: 2rem;
            }

        .form-signin {
            width: 100%;
        }

            .form-signin .btn {
                font-size: 80%;
                border-radius: 5rem;
                letter-spacing: .1rem;
                font-weight: bold;
                padding: 1rem;
                transition: all 0.2s;
            }

        .form-label-group {
            position: relative;
            margin-bottom: 1rem;
        }

            .form-label-group input {
                height: auto;
                border-radius: 2rem;
            }

            .form-label-group > input,
            .form-label-group > label {
                padding: var(--input-padding-y) var(--input-padding-x);
            }

            .form-label-group > label {
                position: absolute;
                top: 0;
                left: 0;
                display: block;
                width: 100%;
                margin-bottom: 0;
                /* Override default `<label>` margin */
                line-height: 1.5;
                color: #495057;
                opacity:0.2;
                border: 1px solid transparent;
                border-radius: .25rem;
                transition: all .1s ease-in-out;
            }

            .form-label-group input::-webkit-input-placeholder {
                color: transparent;
            }

            .form-label-group input:-ms-input-placeholder {
                color: transparent;
               
            }

            .form-label-group input::-ms-input-placeholder {
                color: transparent;
                

            }

            .form-label-group input::-moz-placeholder {
                color: transparent;
            }

            .form-label-group input::placeholder {
                color: transparent;
                
            }

            .form-label-group input:not(:placeholder-shown) {
                padding-top: calc(var(--input-padding-y) + var(--input-padding-y) * (2 / 3));
                padding-bottom: calc(var(--input-padding-y) / 3);
            }

                .form-label-group input:not(:placeholder-shown) ~ label {
                    padding-top: calc(var(--input-padding-y) / 3);
                    padding-bottom: calc(var(--input-padding-y) / 3);
                    font-size: 12px;
                    color: #777;
                }

        .btn-primary {
            color: white;
            background-color: #0080A0;
        }
    </style>

    <script type="text/javascript">
        function Validation() {
            document.getElementById("lblErrorMessage").innerHTML = '';
            var username = document.getElementById("txtUserName");
            if (username)
                if (username.value.trim() == '') {
                    document.getElementById("lblErrorMessage").innerHTML = "***Please enter username";
                    return false;
                }
            var password = document.getElementById("txtPassword");
            if (password)
                if (password.value.trim() == '') {
                    document.getElementById("lblErrorMessage>").innerHTML = '***Please enter password';
                    return false;
                }

            return true;
        }
        function ClearAll() {
            var username = document.getElementById("txtUserName");
            if (username)
                username.value = '';
            var password = document.getElementById("txtPassword");
            if (password)
                password.value = '';
            return false;
        }

        
    </script>
</head>
<body>
        <div class="container"> 
        <div class="row">
                <div class="col-lg-8 col-xl-7 mx-auto d-flex justify-content-center">
                <div class="card card-signin flex-row my-5 justify-content-center" style="width:60%;">
                    <div class="card-body">
                        <h5 class="card-title text-center">
                            <img src="Images/RAFTLogo_280pxH_WHITE_BGCopy.png" alt="Request A Full Text" />
                        </h5>
                        <form class="form-signin" action="/userLogin/login" method="get" >
                            <div class="form-label-group">
                                <input type="text" id="txtUserName" name="txtUserName"  class="form-control" autocomplete="off" placeholder="Username" required autofocus />
                                <label for="txtUserName">Username</label>
                            </div>

                            <br />
                            
                            <div class="form-label-group">
                                <input type="password" id="txtPassword" name="txtPassword"  class="form-control"  autocomplete="off" placeholder="Password" required />
                                <label for="txtPassword">Password</label>
                            </div>

                            <br />
                            <button  ID="btnLogin" OnClick="Validation(); " OnClick="btnLogin_Click" class="btn btn-lg btn-primary btn-block text-uppercase" >Login</button>

                            <div id="divErrors">
                                <label ID="lblErrorMessage" Style="color: red;"></label>
                            </div>
                        </form>

                    </div>
                </div>
            </div>
        </div>
    </div>

</body>
</html>
