import { useState } from 'react'
import { useHistory } from 'react-router-dom';
import NavBar from 'componets/basics/navbar';
import '../Login/style.css'
import Lock from '../../assets/images/login.png'
import Footer from 'componets/basics/footer';

import { MdLock, MdForum } from "react-icons/md"
import { HiEye, HiEyeOff } from "react-icons/hi"
import API from 'services/API';


function Login() {
  const [username, setUser] = useState("")
  const [password, setPassword] = useState("")
  const [show, setShow] = useState(false)

  const history = useHistory();

  async function Login(e:any) {
    e.preventDefault();

    const data = {
      username,
      password,

    }
    try{
      const response = await API.post('auth/login', data);

      localStorage.setItem('username', username);
      localStorage.setItem('token', response.data.token);

      history.push('');

    }catch(error){
      alert('Autenticação sem sucesso, tente novamente!')

    }
  }

  const handleClick = (e: any) => {
    e.preventDefault()
    setShow(!show);
  }

  return (
    <>
      <div className="header">
        <NavBar />
      </div>
      <div className="login">
        <div className="login-logo">
          <img
            src={Lock}
            alt="MdLockLogin App"
          />
        </div>

        <div className="login-right">
          <h1><strong>LOGIN</strong></h1>

          <div className="login-loginInputUser">
            <MdForum />
            <input
              type="user"
              placeholder="Digite seu user"
              value={username}
              onChange={e => setUser(e.target.value)}
            />
          </div>

          <div className="login-loginInputPassword">
            <MdLock />
            <input
              placeholder="Digite sua senha"
              type={show ? "text" : "password"}
              value={password}
              onChange={e => setPassword(e.target.value)}
            />
            <div className="login-eye">
              {show ? (
                <HiEye
                  size={20}
                  onClick={handleClick}
                />
              ) : (
                <HiEyeOff
                  size={20}
                  onClick={handleClick}
                />
              )}
            </div>
          </div>

          <button type="submit">
            ENTRAR
          </button>

        </div>
      </div>
      <div className="header">
        <Footer />
      </div>
    </>
  )
}

export default Login
