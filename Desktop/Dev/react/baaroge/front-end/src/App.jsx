import "./App.scss";
import BasicExample from "./components/BasicExample.jsx";
import Carrousel from "./components/carrousel/Carrousel";
import NavBar from "./components/navbar/NavBar.jsx";
function App() {
  const objects = [
    {
      img : "./logo.png",
      title: "logotipo",
      description: "this is a logo"
    },
    {
      img: "./hr.jpg",
      title:"Welcome",
      description: "this is a banner"
    }
  ]
  return (
    <>
      
      
      <NavBar/>
      <Carrousel imgs={objects}/>
      
    </>
  );
}

export default App;
