import "./App.css";

import BookDetails from "./Components/BookDetails";
import BlogDetails from "./Components/BlogDetails";
import CourseDetails from "./Components/CourseDetails";

function App() {

    const showBooks = true;
    const showBlogs = true;
    const showCourses = true;

    return (

        <div style={{ margin: "20px" }}>

            <h1>Blogger Application</h1>

            {

                showBooks && <BookDetails />

            }

            {

                showBlogs ? <BlogDetails /> : null

            }

            {

                showCourses ? <CourseDetails /> : <h2>No Courses Available</h2>

            }

        </div>

    );

}

export default App;