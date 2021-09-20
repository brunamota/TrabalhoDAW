import JoobPool_head from '../../../assets/images/JoobPool_head.png'

const NavBar = () =>{
    return (
<>        
<nav className="py-2 bg-light border-bottom">
    <div className="container d-flex flex-wrap">
      <ul className="nav me-auto">
        <li className="nav-item"><a href="#" className="nav-link link-dark px-2 active" aria-current="page">Home</a></li>
        <li className="nav-item"><a href="#" className="nav-link link-dark px-2">Vagas de Estágio</a></li>
        <li className="nav-item"><a href="#" className="nav-link link-dark px-2">FAQs</a></li>
        <li className="nav-item"><a href="#" className="nav-link link-dark px-2">UFJ</a></li>
      </ul>
      <ul className="nav">
        <li className="nav-item"><a href="#" className="nav-link link-dark px-2">Login</a></li>
        <li className="nav-item"><a href="#" className="nav-link link-dark px-2">Cadastro</a></li>
      </ul>
    </div>
  </nav>


<header className="py-3 mb-4 border-bottom">
    <div className="container d-flex flex-grow justify-content-center">
      <a  href="/" className="d-flex align-items-center mb-3 mb-lg-0 me-lg-auto text-dark text-decoration-none">
      <img src={JoobPool_head} alt="Job Pool" width="200" />
      </a>
    </div>
  </header>
  </>
    );
}

export default NavBar;