# Music Theory API

This API provides a simple interface for retrieving notes in different scales based on a given key.

## Usage

### Endpoints

The API currently responds to the following GET requests:

- `/scales/[key]/[scale_type]/notes`

  Retrieves a list of notes in the specified scale for the given key.

  - `key`: A musical key, represented as any of the following:
    <table>
      <tr>
        <th>Key</th> <td>C</td> <td>C#/Db</td> <td>D</td> <td>Eb</td> <td>E</td> <td>F</td> <td>F#/Gb</td> <td>G</td> <td>G#/Ab</td> <td>A</td> <td>A#/Bb</td> <td>B</td>
      </tr>
      <tr>
        <th>Endpoint name</th> <td>C</td> <td>Csharp/Dflat</td> <td>D</td> <td>Eflat</td> <td>E</td> <td>F</td> <td>Fsharp/Gflat</td> <td>G</td> <td>Gsharp/Aflat</td> <td>A</td> <td>Bflat</td> <td>B</td>
      </tr>
    </table>
  - `scale_type`: The type of scale:
    <table><tr> <td>major</td> <td>minor</td> </tr></table>
  - Certain key and scale combinations will be altered to return the scale with the least key signatures. For example: Db minor will return C# minor.
 
  

### Example

To retrieve the notes in the C# minor scale, you can make a GET request to:

``0.0.0.0:8080/scales/Csharp/minor/notes``

Response:

``["C#","D#","E","F#","G#","A","B"]``

## TODO
- Get the notes of a given key and scale [x]
- Get the chords of a given key and scale [ ]
- Return a random chord progression for a given key and scale [ ]

